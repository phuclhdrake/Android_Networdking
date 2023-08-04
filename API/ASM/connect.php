<?php 
    $servername = "localhost";
    $username = "id20969708_phucle123";
    $password = "Nhoc2003@";
    $dbname = "id20969708_androidnetwordking";

    $conn = mysqli_connect($servername, $username, $password, $dbname);
    mysqli_query($conn, "SET NAME '.utf8.'");
    if($conn){
        echo "Kết nối thành công";   
       }else{
        echo "Kết nối thất bại";
       }
?>
