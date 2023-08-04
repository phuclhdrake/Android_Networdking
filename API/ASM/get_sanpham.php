<?php 
    include "connect.php";
    $query = "SELECT * FROM Sanpham";
    $data = mysqli_query($conn, $query);
    $mangsp = array();
    while($row = mysqli_fetch_assoc($data)){
        array_push($mangsp, new Sanpham(
            $row['id'],
            $row['tensanpham'],
            $row['giasanpham'],
            $row['hinhanhsanpham'],
            $row['motasanpham'],
            $row['idsanpham'],
        ));
    }
    echo json_encode($mangsp);
    class Sanpham{
        function Sanpham($id, $tensanpham, $giasanpham, $hinhanhsanpham, $motasanpham, $idsanpham) {
            $this->id = $id;
            $this->tensanpham = $tensanpham;
            $this->giasanpham = $giasanpham;
            $this->hinhanhsanpham = $hinhanhsanpham;
            $this->motasanpham = $motasanpham;
            $this->idsanpham = $idsanpham;
        }
    }

?>