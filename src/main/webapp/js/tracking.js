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
        fetchOrderStatus(orderId);
    });

    // Periodic status check every 10 seconds
    setInterval(() => {
        const orderId = document.getElementById('order-id').value;
        if (orderId) fetchOrderStatus(orderId);
    }, 10000);
});

function fetchOrderStatus(orderId) {
    fetch(`/api/track-order/${orderId}`)
        .then(response => response.json())
        .then(data => updateOrderStatus(data))
        .catch(error => {
            document.getElementById('order-status').innerHTML = `<p>There was an error retrieving your order status.</p>`;
        });
}

function updateOrderStatus(data) {
    const orderStatusDiv = document.getElementById('order-status');
    if (data.error) {
        orderStatusDiv.innerHTML = `<p>${data.error}</p>`;
    } else {
        orderStatusDiv.innerHTML = `
            <h3>Order Status</h3>
            <p><strong>Order ID:</strong> ${data.orderId}</p>
            <p><strong>Car Model:</strong> ${data.carModel}</p>
            <p><strong>Status:</strong> ${data.status}</p>
            <p><strong>Estimated Delivery Date:</strong> ${data.estimatedDeliveryDate}</p>
        `;

        // Send email notification when the car is ready for pick-up
        if (data.status === 'Ready for Pick-Up') {
            sendPickupNotification(data.orderId);
        }
    }
}

function sendPickupNotification(orderId) {
    fetch(`/api/notify-pickup/${orderId}`)
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                console.log("Notification sent");
            }
        });
}

function getUserRole() {
    // Replace this logic with your actual role-checking logic
    return document.body.dataset.role || 'customer';
}
