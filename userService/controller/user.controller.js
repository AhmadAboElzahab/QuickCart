const User = require("../model/user.model");
async function getAll(req, res) {
  try {
    const users = await User.find();
    res.status(200).json(users);
  } catch (error) {
    console.error("Error getting all users:", error);
    res.status(500).json({ error: "Internal Server Error" });
  }
}
async function getOne(req, res) {
  try {
    const userEmail = req.params.email;
    const user = await User.findOne({ email: userEmail });
    if (!user) {
      return res.status(404).json({ error: "User not found" });
    }
    res.status(200).json(user);
  } catch (error) {
    console.error("Error getting user by email:", error);
    res.status(500).json({ error: "Internal Server Error" });
  }
}
async function deleteUser(req, res) {
  try {
    const userEmail = req.params.email;
    const deletedUser = await User.findOneAndDelete({ email: userEmail });
    if (!deletedUser) {
      return res.status(404).json({ error: "User not found" });
    }
    res.status(200).json({ message: "User deleted successfully", deletedUser });
  } catch (error) {
    console.error("Error deleting user by email:", error);
    res.status(500).json({ error: "Internal Server Error" });
  }
}

async function addUser(req, res) {
  try {
    const { email, SecurityCode, name, balance } = req.body;
    const newUser = new User({
      email,
      SecurityCode,
      name,
      balance,
    });

    const savedUser = await newUser.save();
    res.status(201).json(savedUser);
  } catch (error) {
    console.error("Error adding user:", error);
    res.status(500).json({ error: "Internal Server Error" });
  }
}
async function pay(req, res) {
  try {
    const { email, securityCode, amount } = req.body;
    const user = await User.findOne({ email });
    if (user.SecurityCode != securityCode) {
      return res.status(400).json({ message: "security code is incorrect" });
    }
    if (!user) {
      return res
        .status(404)
        .json({ error: "User not found or security code is incorrect" });
    }
    if (amount <= 0 || amount > user.balance) {
      return res.status(400).json({ message: "Invalid  amount" });
    }
    user.balance -= amount;
    await user.save();
    res.status(200).json({ message: "Withdrawal successful" });
  } catch (error) {
    console.error("Error withdrawing funds:", error);
    res.status(500).json({ message: "Internal Server Error" });
  }
}
module.exports = {
  getAll,
  getOne,
  deleteUser,
  addUser,
  pay,
};
