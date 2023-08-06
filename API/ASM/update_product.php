<?php


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
if (isset($_POST['id']) && isset($_POST['tensanpham']) && isset($_POST['giasanpham']) && isset($_POST['hinhanhsanpham'])  && isset($_POST['motasanpham']) && isset($_POST['idsanpham'])  ) {

    $id = $_POST['id'];
    $tensanpham = $_POST['tensanpham'];
    $giasanpham = $_POST['giasanpham'];
    $hinhanhsanpham = $_POST['hinhanhsanpham'];
    $motasanpham = $_POST['motasanpham'];
    $idsanpham = $_POST['idsanpham'];

    
    $sql = "UPDATE Sanpham SET tensanpham = '$tensanpham', giasanpham = '$giasanpham', hinhanhsanpham = '$hinhanhsanpham', motasanpham = '$motasanpham', idsanpham = '$idsanpham' WHERE id = $id";

    if ($conn->query($sql) === TRUE) {
      //echo "Record updated successfully";
        // successfully updated
        $response["success"] = 1;
        $response["message"] = "Product successfully updated.";

        // echoing JSON response
        echo json_encode($response);
    } else {
      echo "Error updating record: " . $conn->error;
    }

    $conn->close();

} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";

    // echoing JSON response
    echo json_encode($response);
}
?>
