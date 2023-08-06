<?php

/*
 * Following code will create a new product row
 * All product details are read from HTTP Post Request
 */

// array for JSON response
$response = array();

$servername = "localhost";
$username = "id20969708_phucle123";
$password = "Nhoc2003@";
$dbname = "id20969708_androidnetwordking";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

// check for required fields
if (isset($_POST['tensanpham']) && isset($_POST['giasanpham']) && isset($_POST['hinhanhsanpham']) && isset($_POST['motasanpham']) && isset($_POST['idsanpham'])) {

  $tensanpham = $_POST['tensanpham'];
  $giasanpham = $_POST['giasanpham'];
  $hinhanhsanpham = $_POST['hinhanhsanpham'];
  $motasanpham = $_POST['motasanpham'];
  $idsanpham = $_POST['idsanpham'];

  // include db connect class
  //require_once __DIR__ . '/db_connect.php';

  // connecting to db
  //$db = new DB_CONNECT();

  $sql = "INSERT INTO Sanpham(tensanpham, giasanpham, hinhanhsanpham, motasanpham, idsanpham) VALUES('$tensanpham', '$giasanpham', '$hinhanhsanpham', '$motasanpham', '$idsanpham')";

if ($conn->query($sql) === TRUE) {
  $response["success"] = 1;
  $response["message"] = "Product successfully created.";
  // echoing JSON response
  echo json_encode($response);
  //echo "New record created successfully";
} else {
  // required field is missing
  $response["success"] = 0;
  $response["message"] = "Required field(1) is missing";

  // echoing JSON response
  echo json_encode($response);
//echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();


} else {
  // required field is missing
  $response["success"] = 0;
  $response["message"] = "Required field(2) is missing";

  // echoing JSON response
  echo json_encode($response);
}
?>
