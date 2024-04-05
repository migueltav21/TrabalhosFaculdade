SELECT Room.*, Guest.guestName
FROM Room JOIN Hotel ON Room.hotelNo = Hotel.hotelNo
LEFT JOIN (
    SELECT *
    FROM Booking
    WHERE '2020-04-03' BETWEEN Booking.dateFrom AND Booking.dateTo
) AS Booking ON Room.hotelNo = Booking.hotelNo AND Room.roomNo = Booking.roomNo
LEFT JOIN Guest ON Booking.guestNo = Guest.guestNo
WHERE Hotel.hotelName = 'Grosvenor Hotel';