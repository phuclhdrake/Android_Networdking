<?php

/*
 * Following code will list all the products
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

$result = $conn->query("SELECT *FROM Sanpham");

if ($result->num_rows > 0) {
    // looping through all results
    // products node
    $response["Sanpham"] = array();
    while($row = $result->fetch_assoc()) {
    //while ($row = mysql_fetch_array($result)) {
        // temp user array
        $product = array();
        $product["id"] = $row["id"];
        $product["tensanpham"] = $row["tensanpham"];
        $product["giasanpham"] = $row["giasanpham"];
        $product["hinhanhsanpham"] = $row["hinhanhsanpham"];
        $product["motasanpham"] = $row["motasanpham"];
        $product["idsanpham"] = $row["idsanpham"];

        // push single product into final response array
        array_push($response["Sanpham"], $product);
    }
    // success
    $response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);
} else {
    // no products found
    $response["success"] = 0;
    $response["message"] = "No products found";

    // echo no users JSON
    echo json_encode($response);
}
?>
