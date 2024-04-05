SELECT SUM(Room.price) AS total_income
FROM Booking
JOIN Room ON Booking.roomNo = Room.roomNo AND Booking.hotelNo = Room.hotelNo
JOIN Hotel ON Booking.hotelNo = Hotel.hotelNo
WHERE Hotel.hotelName = 'Grosvenor Hotel'
and '2020-04-03' BETWEEN Booking.dateFrom AND Booking.dateTo;