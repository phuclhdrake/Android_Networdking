<?php
//tao mang chua ket qua json
$response = array();
//Khai bao cac bien
$server = "localhost";
$u = "id20969708_phucle123";
$p = "Nhoc2003@";
$db = "id20969708_androidnetwordking";
//tao ket noi voi CSDL
$con = new mysqli($server, $u, $p, $db);
//kiem tra ket noi, neu co loi thi thong bao
if ($con->connect_error) {
     die("Loi ket noi: " . $con->connect_error);
}
// kiem tra du lieu truyen vao api
if (isset($_GET['fullname']) && isset($_GET['category']) && isset($_GET['price'])) {
     // truyen du lieu vao cac bien
     $fullname = $_GET['fullname'];
     $category = $_GET['category'];
     $price = $_GET['price'];
     //thuc hien insert du lieu
     $sql = "INSERT INTO MyProduct(fullname, category, price) VALUES ('$fullname', '$category', '$price')";
     //thuc hien insert
     if ($con->query($sql) === TRUE) {
          $response['success'] = 1;
          $response['message'] = "Thanh cong";
          // truyen du lieu sang dang json
          echo json_encode($response);
     } else {
          $response['success'] = 0;
          $response['message'] = "Insert that bai";
          // truyen du lieu sang dang json
          echo json_encode($response);
     }
}
$con->close(); // dong ket noi
?>