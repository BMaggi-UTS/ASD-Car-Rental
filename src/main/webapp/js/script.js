function filterFunction() {

const input = document.getElementById("pickup");
const filter = input.value.toUpperCase();
const div = document.getElementById("search-results");
const button = div.getElementsByTagName("a");
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
    const button = div.getElementsByTagName("a");
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
    const a = div.getElementsByTagName("a");
    document.getElementById("pickup").value = result;
    for (let i = 0; i < a.length; i++) {
        a[i].style.display = "none";
    }
}
function clickResultPickup2(result) {
    const div = document.getElementById("search-results2");
    const a = div.getElementsByTagName("a");
    document.getElementById("dropoff").value = result;
    for (let i = 0; i < a.length; i++) {
        a[i].style.display = "none";
    }
}

function darken(field) {
    const targetButton = document.getElementById(field);
    const buttons = document.getElementById("priceorkm").getElementsByTagName("button");
    for(let i = 0; i < buttons.length; i++) {
        if(buttons[i].id == field) {
            buttons[i].className = "selected";
            document.getElementById("km-holder").style.display = "";
            document.getElementById("selected-type").value = field;
            console.log("Selected type = " + field);
        } else {
            buttons[i].className = "not-selected";
            document.getElementById("km-holder").style.display = "none";
        }
    }
}


document.getElementById("pickup-date").value = date.getFullYear().toString() + '-' + (date.getMonth() + 1).toString().padStart(2, 0) + '-' + date.getDate().toString().padStart(2, 0);