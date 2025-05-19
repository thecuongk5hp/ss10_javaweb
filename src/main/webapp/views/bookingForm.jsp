<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking Form</title>
</head>
<body>
<h2>Đặt vé xem phim</h2>
<form action="booking" method="post">
    <label>Tiêu đề phim:</label><br>
    <input type="text" name="movieTitle" required><br><br>

    <label>Thời gian chiếu:</label><br>
    <input type="datetime-local" name="showTime" required><br><br>

    <label>Chọn ghế:</label><br>
    <input type="checkbox" name="selectedSeats" value="A1">A1
    <input type="checkbox" name="selectedSeats" value="A2">A2
    <input type="checkbox" name="selectedSeats" value="A3">A3
    <input type="checkbox" name="selectedSeats" value="B1">B1
    <input type="checkbox" name="selectedSeats" value="B2">B2
    <br><br>

    <button type="submit">Đặt vé</button>
</form>
</body>
</html>
