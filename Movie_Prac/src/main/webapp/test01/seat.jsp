<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*" isELIgnored="false"%>
<%@ taglib prefix ="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %> </날짜/>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value = "${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
const container = document.querySelector('.container');
const seats = document.querySelectorAll('.row .seat:not(.occupied)');
const count = document.querySelector('#count');
const total = document.querySelector('#total');
const movieSelect = document.querySelector('#movie');
const clearBtn = document.querySelector('.clear');

let ticketPrice = +movieSelect.value;

// Get data from localStorage and populate UI
const populateUI = () => {
    const selectedSeats = JSON.parse(localStorage.getItem('selectedSeats'));

    if(selectedSeats !== null && selectedSeats.length > 0) {
        seats.forEach((seat, idx) => {
            if(selectedSeats.indexOf(idx) > -1) {
                seat.classList.add('selected');
            }
        })
    } else {
        seats.forEach(seat => {
            seat.classList.remove('selected');
        })
    }

    const selectedMovieIdx = localStorage.getItem('selectedMovieIdx');

    if (selectedMovieIdx != null) {
        movieSelect.selctedIdx = selectedMovieIdx;
    }
}

populateUI();

// Save selected movie idx and price
const setMovieData = (movieIdx, moviePrice) => {
    localStorage.setItem('selectedMovieIndex', movieIdx);
    localStorage.setItem('selectedMoviePrice', moviePrice);
}

// Update total and cnt
const updateSelectedCount = () => {
    const selectedSeats = document.querySelectorAll('.row .seat.selected');
    const seatsIndex = [...selectedSeats].map(seat => {
        return [...seats].indexOf(seat);
    });
    const selectedSeatsCnt = selectedSeats.length;

    localStorage.setItem('selectedSeats', JSON.stringify(seatsIndex))

    count.innerText = selectedSeatsCnt;
    total.innerText = selectedSeatsCnt * ticketPrice;
}



// Movie select Event
movieSelect.addEventListener('change', e => {
    ticketPrice = +e.target.value;
    setMovieData(e.target.selectedIndex, e.target.value);
    updateSelectedCount()
})

// Seat Click Event
container.addEventListener('click' ,(e) => {
    if (e.target.classList.contains('seat') &&
        !e.target.classList.contains('occupied')
    ) {
        e.target.classList.toggle('selected');
        updateSelectedCount();
    }
})

// clear btn click event
clearBtn.addEventListener('click',() => {
    localStorage.clear();
    console.log('clear btn clicked');
    populateUI()
    updateSelectedCount();
})

// Initial ctn and total set
updateSelectedCount();
</script>
 <style>
 @import url('https://fonts.googleapis.com/css2?family=Lato:ital@1&display=swap');

* {
    box-sizing: border-box;
}

body {
    background-color: white;
    color: #fff;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
    font-family: 'Lato', sans-serif;
    margin: 0;
}

.main{
border: solid 3px #ff9999;
background-color: pink;
width:400px;
    color: #fff;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 500px;
    font-family: 'Lato', sans-serif;
    margin: 0;
    border-radius: 50px;
}

.movie-container {
    margin: 20px 0;
}

.movie-container h1 {
    background: #1E1C28;
    padding: 10px;
}

.movie-container select {
    background: #fff;
    border: 0;
    border-radius: 5px;
    font-size: 14px;
    margin-left: 10px;
    padding: 5px 15px;
    appearance: none;
}

.container {
    perspective: 1000px;
    margin-bottom: 30px;
}

.seat {
    background: #444451;
    height: 12px;
    width: 15px;
    margin: 3px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}
.seat1 {
font-size: 13px;
    height: 12px;
    width: 15px;
    margin: 3px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}

.seat.selected {
    background: #6feaf6;
}

.seat.occupied {
    background: #fff;
}

.seat:nth-of-type(2) {
    margin-right: 18px;
}

.seat:nth-last-of-type(2) {
    margin-left: 18px;
}

.seat:not(.occupied):hover {
    cursor: pointer;
    transform: scale(1.2);
}

.showcase .seat:not(.occupied):hover {
    cursor: default;
    transform: scale(1);
}

.showcase {
    background: rgba(0,0,0, 0.1);
    padding: 5px 10px;
    border-radius: 5px;
    color: #777;
    list-style-type: none;
    display: flex;
    justify-content: space-between;
}

.showcase li {
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0 10px;
}

.showcase li small {
    margin-left: 2px;
}

.row {
        display: flex;
    flex-wrap: wrap;
    align-items: stretch;
    justify-content: space-around;
}

.screen {
    background: #fff;
    height: 70px;
    width: 100%;
    margin: 15px 0;
    transform: rotateX(-45deg);
    box-shadow: 0 3px 10px rgba(255, 255, 255, 0.7);
}

p.text {
    margin: 5px 0;
}

p.text span {
    color: #6feaf6;
}

.clear {
    background: #777;
    border: 2px solid #777;
    border-radius: 5px;
    width: 55px;
    margin-top: 10px;
    font-size: 14px;
    font-weight: 600;
}

.clear:hover {
    cursor: pointer;
}
</style>
<title>Insert title here</title>
</head>
<body>
<h1>좌석 선택</h1>
<form class="main" method = "post" action ="${contextPath}/movie1/rowcol.do">
<h1>Movie Seat Booking 💟ྀི</h1>
<div class="movie-container">
    <label for="movie">Pick a movie Seats</label>
</div>


<div class="container">
    <div class="screen"></div>
    
    <div class="row">
        <div class ="seat1">A</div>
        <input type ="checkbox" class="seat" name ="seat" value="A-1">
        <input type ="checkbox" class="seat" name ="seat" value="A-2">
        <input type ="checkbox" class="seat" name ="seat" value="A-3">
        <input type ="checkbox" class="seat" name ="seat" value="A-4">
        <input type ="checkbox" class="seat" name ="seat" value="A-5">
        <input type ="checkbox" class="seat" name ="seat" value="A-6">
        <input type ="checkbox" class="seat" name ="seat" value="A-7">
    </div>
    <div class="row">
    <div class ="seat1">B</div>
      <input type ="checkbox" class="seat" name ="seat" value="B-1">
        <input type ="checkbox" class="seat" name ="seat" value="B-2">
        <input type ="checkbox" class="seat" name ="seat" value="B-3">
        <input type ="checkbox" class="seat" name ="seat" value="B-4">
        <input type ="checkbox" class="seat" name ="seat" value="B-5">
        <input type ="checkbox" class="seat" name ="seat" value="B-6">
        <input type ="checkbox" class="seat" name ="seat" value="B-7">
    </div>
    <div class="row">
    <div class ="seat1">C</div>
        <input type ="checkbox" class="seat" name ="seat" value="C-1">
        <input type ="checkbox" class="seat" name ="seat" value="C-2">
        <input type ="checkbox" class="seat" name ="seat" value="C-3">
        <input type ="checkbox" class="seat" name ="seat" value="C-4">
        <input type ="checkbox" class="seat" name ="seat" value="C-5">
        <input type ="checkbox" class="seat" name ="seat" value="C-6">
        <input type ="checkbox" class="seat" name ="seat" value="C-7">
    </div>
    <div class="row">
    <div class ="seat1">D</div>
        <input type ="checkbox" class="seat" name ="seat" value="D-1">
        <input type ="checkbox" class="seat" name ="seat" value="D-2">
        <input type ="checkbox" class="seat" name ="seat" value="D-3">
        <input type ="checkbox" class="seat" name ="seat" value="D-4">
        <input type ="checkbox" class="seat" name ="seat" value="D-5">
        <input type ="checkbox" class="seat" name ="seat" value="D-6">
        <input type ="checkbox" class="seat" name ="seat" value="D-7">
    </div>
    <div class="row">
    <div class ="seat1">E</div>
        <input type ="checkbox" class="seat" name ="seat" value="E-1">
        <input type ="checkbox" class="seat" name ="seat" value="E-2">
        <input type ="checkbox" class="seat" name ="seat" value="E-3">
        <input type ="checkbox" class="seat" name ="seat" value="E-4">
        <input type ="checkbox" class="seat" name ="seat" value="E-5">
        <input type ="checkbox" class="seat" name ="seat" value="E-6">
        <input type ="checkbox" class="seat" name ="seat" value="E-7">
    </div>
   
</div>

<button type ="submit" id="clearBtn" class="clear">select</button>
</form>
</body>
</html>