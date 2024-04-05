SELECT Guest.*, Booking.dateFrom, Booking.dateTo
FROM Guest
JOIN Booking ON Guest.guestNo = Booking.guestNo
WHERE Booking.hotelNo = (SELECT hotelNo FROM Hotel WHERE hotelName = 'Grosvenor Hotel') and '2020-04-03' between dateFrom and dateTo;
