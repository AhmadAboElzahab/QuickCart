const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const userSchema = new Schema({
  email: {
    type: String,
    required: [true, "Please enter an email"],
    unique: true,
  },
  SecurityCode: {
    type: Number,
    required: [true, "Please enter a password"],
  },
  name: {
    type: String,
    required: [true, "Please enter your name"],
  },
  balance: {
    type: Number,
    required: [true, "Please enter your name"],
  },
});

module.exports = mongoose.model("User", userSchema);
