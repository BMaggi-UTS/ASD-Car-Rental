function filterFunction() {

const input = document.getElementById("pickup");
const filter = input.value.toUpperCase();
const div = document.getElementById("search-results");
const button = div.getElementsByTagName("button");
for (let i = 0; i < button.length; i++) {
    txtValue = button[i].textContent || button[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
    button[i].style.display = "block";
    } else {
        button[i].style.display = "none";
    }
    if(filter.length == "") {
        button[i].style.display = "none";
    }
}
}
function filterFunction2() {

    const input = document.getElementById("dropoff");
    const filter = input.value.toUpperCase();
    const div = document.getElementById("search-results2");
    const button = div.getElementsByTagName("button");
    for (let i = 0; i < button.length; i++) {
        txtValue = button[i].textContent || button[i].innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
        button[i].style.display = "block";
        } else {
            button[i].style.display = "none";
        }
        if(filter.length == "") {
            button[i].style.display = "none";
        }
    }
}
function clickResultPickup(result) {
    const div = document.getElementById("search-results");
    const button = div.getElementsByTagName("button");
    document.getElementById("pickup").value = result;
    for (let i = 0; i < button.length; i++) {
        button[i].style.display = "none";
    }
}
function clickResultPickup2(result) {
    const div = document.getElementById("search-results2");
    const button = div.getElementsByTagName("button");
    document.getElementById("dropoff").value = result;
    for (let i = 0; i < button.length; i++) {
        button[i].style.display = "none";
    }
}

function darken(field) {
    const targetButton = document.getElementById(field);
    const buttons = document.getElementById("priceorkm").getElementsByTagName("button");
    for(let i = 0; i < buttons.length; i++) {
        if(buttons[i].id == field) {
            buttons[i].className = "selected";
            document.getElementById("km-holder").style.display = "";
        } else {
            buttons[i].className = "not-selected";
            document.getElementById("km-holder").style.display = "none";
        }
    }
}