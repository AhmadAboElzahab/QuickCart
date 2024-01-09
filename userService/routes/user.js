const express = require("express");
const router = express.Router();
const {
  getAll,
  getOne,
  deleteUser,
  addUser,
  pay,
} = require("../controller/user.controller");

router.get("/all", getAll);
router.get("/:email", getOne);
router.post("/add", addUser);
router.delete("/delete/:email", deleteUser);
router.post("/pay", pay);

module.exports = router;
