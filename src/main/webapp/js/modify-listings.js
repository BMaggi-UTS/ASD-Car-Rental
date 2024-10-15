function swap(field) {
    const cell = document.getElementById(field);
    const input = cell.children[1];
    const text = cell.children[0];
    if(input.className === "hidden") {
        input.className = "not-hidden";
        text.className = "hidden";
        input.value = text.innerText;
        cell.className = "bg-active"
    }
}
function editAll() {
    const cells = document.getElementsByTagName("td");
    for(const cell of cells)  {
        if(cell.children.length === 2) {
            console.log(cell.children[0]);
            cell.className = "bg-active";
            cell.children[0].className = "hidden";
            cell.children[1].className = "not-hidden";
            cell.children[1].value = cell.children[0].innerText;
        }
    }
}
function openModal(modalID) {
    const overlay = document.getElementById(modalID);
    const modal = overlay.children[0];
    overlay.style.display = "block";
    modal.style.transform = "translate(-50%, -50%) scale(1)";
}
function closeModal(modalID) {
    const overlay = document.getElementById(modalID + "overlay");
    overlay.style.display = "none";
}