<?php
$response = array();

$server = "localhost";
$u = "id20969708_phucle123";
$p = "Nhoc2003@";
$db = "id20969708_androidnetwordking";
//tao ket noi voi CSDL
$conn = new mysqli($server, $u, $p, $db);
// Check connection
if ($conn->connect_error) {
     die("Loi ket noi: " . $conn->connect_error);
}

// sql to delete a record
$sql = "DELETE FROM MyProduct WHERE id=6";

if ($conn->query($sql) === TRUE) {
     $response['success'] = 1;
     $response['message'] = "Thanh cong";
     echo "Record deleted successfully";
} else {
     $response['success'] = 0;
     $response['message'] = "Insert that bai";
     echo "Error deleting record: " . $conn->error;
}

$conn->close();
?>