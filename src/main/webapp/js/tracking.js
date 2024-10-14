document.addEventListener('DOMContentLoaded', function() {
    const role = getUserRole();
    const customerView = document.getElementById('customer-view');
    const adminView = document.getElementById('admin-view');
    
    if (role === 'admin') {
        customerView.style.display = 'none';
        adminView.style.display = 'block';
        document.body.classList.add('show-admin');
    } else {
        adminView.style.display = 'none';
        customerView.style.display = 'block';
        document.body.classList.add('show-customer');
    }

    const form = document.getElementById('track-order-form');
    form.addEventListener('submit', function(event) {
        event.preventDefault();
        const orderId = document.getElementById('order-id').value;

        // For presentation purposes, simulate order details display
        showOrderDetails(orderId);
    });
});

function showOrderDetails(orderId) {
    const orderStatusDiv = document.getElementById('order-status');
    
    // Simulated order details for presentation
    orderStatusDiv.innerHTML = `
        <h3>Order Details for Order ID: ${orderId}</h3>
        <p><strong>Car Model:</strong> Tesla Model S</p>
        <p><strong>Status:</strong> In Transit</p>
        <p><strong>Estimated Delivery Date:</strong> 12th October 2024</p>
        <p><strong>Shipping Address:</strong> 123 Main Street, Sydney, NSW</p>
    `;

    // Scroll to the order status section
    orderStatusDiv.scrollIntoView({ behavior: 'smooth' });
}

function getUserRole() {
    // Replace this logic with your actual role-checking logic
    return document.body.dataset.role || 'customer';
}
