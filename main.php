<style>
    .error {
        color: red;
    }
</style>
<?php
$nameerr = $emailerr = $mobileerr = "";
$name = $email = $mobile = "";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (empty($_POST["t1"])) {
        $nameerr = "Enter name";
    } else {
        $name = $_POST["t1"];
        $namepattern = "/^[a-zA-Z ]*$/";
        if (!preg_match($namepattern, $name)) {
            $nameerr = "Enter Alphabet only";
        }
    }

    if (empty($_POST["t2"])) {
        $emailerr = "Enter Email";
    } else {
        $email = $_POST["t2"];
        if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
            $emailerr = "Enter Valid Email";
        }
    }

    if (empty($_POST["t3"])) {
        $mobileerr = "Enter Mobile Number";
    } else {
        $mobile = $_POST["t3"];
        $mpattern = "/^[0-9]*$/";
        if (!preg_match($mpattern, $mobile)) {
            $mobileerr = "Enter only Number";
        }
        if (strlen($mobile) != 10) {
            $mobileerr = "Enter 10 digit Mobile Number";
        }
    }
}
?>

<form action="<?php $_SERVER["PHP_SELF"]; ?>" method="post">
    <label>Name :</label>
    <input type="text" name="t1">
    <span class="error">*<?php echo $nameerr; ?></span><br>

    <label>Email :</label>
    <input type="text" name="t2">
    <span class="error">*<?php echo $emailerr; ?></span><br>

    <label>Mobile :</label>
    <input type="text" name="t3">
    <span class="error">*<?php echo $mobileerr; ?></span><br>

    <input type="submit" name="submit" value="Submit">
</form>
<?php
$host = 'localhost';
$user = 'root';
$pass = '1234';
$db = 'Db';

$conn = new mysql($host,$user,$pass,$db);
$na=$_POST['t1'];
$em=$_POST['t2'];
$nu=$_POST['t3'];

$sql = "insert into user values('$na','$em',$nu)";

if($conn->query($sql)=== True)
echo 'Row Inserted';
else
echo 'Not Inserted';

$conn->close();
?>