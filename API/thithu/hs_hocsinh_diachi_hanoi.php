<?php

/*
 * Following code will list all the students with address "ha noi"
 */

// Array for JSON response
$response = array();

$servername = "localhost";
$username = "id20969708_phucle11";
$password = "Nhoc2003@";
$dbname = "id20969708_thithu_android_networdking";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$searchAddress = "ha noi"; // The address you want to search for

$query = "SELECT Hocsinh.*, Lop.tenlop
          FROM Hocsinh
          INNER JOIN Lop ON Hocsinh.idlop = Lop.idlop
          WHERE Hocsinh.diachi LIKE '%$searchAddress%'";

$result = $conn->query($query);

if ($result->num_rows > 0) {
    // Looping through all results
    // Students node
    $response["students"] = array();
    while ($row = $result->fetch_assoc()) {
        // Temp student array
        $student = array();
        $student["idhocsinh"] = $row["idhocsinh"];
        $student["hoten"] = $row["hoten"];
        $student["ngaysinh"] = $row["ngaysinh"];
        $student["gioitinh"] = $row["gioitinh"];
        $student["diachi"] = $row["diachi"];
        $student["loptruong"] = $row["loptruong"];
        $student["bithuchidoan"] = $row["bithuchidoan"];
        $student["ghichu"] = $row["ghichu"];
        $student["tenlop"] = $row["tenlop"]; // Add class name to the response

        // Push single student into final response array
        array_push($response["students"], $student);
    }
    // Success
    $response["success"] = 1;

    // Echoing JSON response
    echo json_encode($response);
} else {
    // No students found
    $response["success"] = 0;
    $response["message"] = "No students found with the specified address";

    // Echo no students JSON
    echo json_encode($response);
}

$conn->close();
?>
