SELECT Room.* from Room where hotelNo = ( select hotelNo from Hotel where hotelName = 'Grosvenor Hotel')
AND Room.roomNo NOT IN (
    SELECT roomNo
    FROM Booking
    WHERE hotelNo = (SELECT hotelNo FROM Hotel WHERE hotelName = 'Grosvenor Hotel')
   and '2020-04-03' BETWEEN Booking.dateFrom AND Booking.dateTo
)