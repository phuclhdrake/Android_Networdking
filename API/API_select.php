<?php
$servername = "localhost";
$username = "id20969708_phucle123";
$password = "Nhoc2003@";
$dbname = "id20969708_androidnetwordking";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
     die("Lỗi kết nối: " . mysqli_connect_error());
}

$sql = "SELECT id, fullname, category, price FROM MyProduct";
$result = mysqli_query($conn, $sql);

if (mysqli_num_rows($result) > 0) {
     // output data of each row
     while ($row = mysqli_fetch_assoc($result)) {
          echo "id: " . $row["id"] . " - fullname: " . $row["fullname"] . " - Category: " . $row["category"] . " - Price: " . $row["price"] . "<br>";
     }
} else {
     echo "0 results";
}

mysqli_close($conn);
?>