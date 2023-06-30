<?php
$servername = "localhost";
$username = "id20969708_phucle123";
$password = "Nhoc2003@";
$dbname = "id20969708_androidnetwordking";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
     die("Lỗi kết nối: " . $conn->connect_error);
}

$sql = "UPDATE MyProduct SET fullname='Doe hihi' WHERE id=1";

if ($conn->query($sql) === TRUE) {
     echo "Update thanh cong";
} else {
     echo "Update that bai: " . $conn->error;
}

$conn->close();
?>