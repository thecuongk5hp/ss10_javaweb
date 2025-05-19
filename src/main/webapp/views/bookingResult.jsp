<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Thông tin vé</title>
</head>
<body>
<h2>Thông tin đặt vé</h2>
<p><strong>Phim:</strong> ${ticket.movieTitle}</p>
<p><strong>Thời gian:</strong> ${ticket.showTime}</p>
<p><strong>Ghế:</strong>
  <c:forEach var="seat" items="${ticket.seats}">
    ${seat.seatNumber}
  </c:forEach>
</p>
<p><strong>Tổng tiền:</strong> $${ticket.totalAmount}</p>
</body>
</html>
