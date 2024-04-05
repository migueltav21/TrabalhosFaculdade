select hotelNo, count(roomNo) as totalQuartos from Room where hotelNo IN (select hotelNo from Hotel where city = 'London')
group by hotelNo