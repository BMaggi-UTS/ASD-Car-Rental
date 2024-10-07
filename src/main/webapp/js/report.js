document.addEventListener('DOMContentLoaded', function () {
    const sections = document.querySelectorAll('.report-section h2');

    // Sales Report Elements
    const generateSalesReportBtn = document.getElementById('generate-sales-report');
    const exportSalesPdfBtn = document.getElementById('export-sales-pdf');
    const salesStartDate = document.getElementById('sales-start-date');
    const salesEndDate = document.getElementById('sales-end-date');
    const salesReportTableBody = document.querySelector('#sales-report-table tbody');

    // Monthly Sales Report Elements
    const generateMonthlySalesReportBtn = document.getElementById('generate-monthly-sales-report');
    const salesMonthSelect = document.getElementById('sales-month');
    const monthlySalesReportTableBody = document.querySelector('#monthly-sales-report-table tbody');

    // Feedback Report Elements
    const generateFeedbackReportBtn = document.getElementById('generate-feedback-report');
    const exportFeedbackPdfBtn = document.getElementById('export-feedback-pdf');
    const feedbackStartDate = document.getElementById('feedback-start-date');
    const feedbackEndDate = document.getElementById('feedback-end-date');
    const feedbackReportTableBody = document.querySelector('#feedback-report-table tbody');

    // Toggle report section visibility
    sections.forEach(section => {
        section.addEventListener('click', function () {
            const nextElement = section.nextElementSibling;
            nextElement.classList.toggle('active');
        });
    });

    // Populate month and year dropdown
    function populateMonthSelect(selectElement) {
        const currentYear = new Date().getFullYear();
        let options = '';
        for (let year = currentYear; year >= 2000; year--) {
            for (let month = 1; month <= 12; month++) {
                const monthName = new Date(year, month - 1).toLocaleString('default', { month: 'long' });
                options += `<option value="${year}-${month}">${monthName} ${year}</option>`;
            }
        }
        selectElement.innerHTML = options;
    }

    populateMonthSelect(salesMonthSelect);

    // Generate Custom Sales Report
    generateSalesReportBtn.addEventListener('click', function () {
        const startDate = salesStartDate.value;
        const endDate = salesEndDate.value;

        if (startDate && endDate) {
            // Fetch data from the backend (simulate with static data)
            // In a real application, you'd use fetch() or $.ajax() to get data from the server
            // For example:
            // fetch(`/getSalesReport?startDate=${startDate}&endDate=${endDate}`)
            //     .then(response => response.json())
            //     .then(data => { /* Populate table */ });

            // Simulated data
            const data = [
                { date: '2024-09-05', customers: 10, carsRented: 8, revenue: 2000 },
                { date: '2024-09-06', customers: 12, carsRented: 10, revenue: 2500 },
                // Add more data as needed
            ];

            // Clear previous data
            salesReportTableBody.innerHTML = '';

            // Populate table with data
            data.forEach(item => {
                const row = `<tr>
                    <td>${item.date}</td>
                    <td>${item.customers}</td>
                    <td>${item.carsRented}</td>
                    <td>$${item.revenue}</td>
                </tr>`;
                salesReportTableBody.insertAdjacentHTML('beforeend', row);
            });
        } else {
            alert('Please select both start and end dates.');
        }
    });

    // Export Sales Report as PDF
    exportSalesPdfBtn.addEventListener('click', function () {
        const { jsPDF } = window.jspdf;
        const doc = new jsPDF();

        doc.text('Custom Sales Report', 10, 10);
        doc.autoTable({ html: '#sales-report-table', startY: 20 });
        doc.save('Custom_Sales_Report.pdf');
    });

    // Generate Monthly Sales Report
    generateMonthlySalesReportBtn.addEventListener('click', function () {
        const selectedMonth = salesMonthSelect.value;
        if (selectedMonth) {
            // Fetch data from backend
            // Simulated data
            const data = {
                '2024-9': {
                    month: 'September 2024',
                    customers: 200,
                    carsRented: 150,
                    monthlyRevenue: 50000,
                    avgSpending: 250,
                    totalRevenue: 50000
                },
                // Add data for other months
            };

            const report = data[selectedMonth];

            if (report) {
                monthlySalesReportTableBody.innerHTML = `
                    <tr>
                        <td>${report.month}</td>
                        <td>${report.customers}</td>
                        <td>${report.carsRented}</td>
                        <td>$${report.monthlyRevenue}</td>
                        <td>$${report.avgSpending}</td>
                        <td>$${report.totalRevenue}</td>
                    </tr>
                `;
            } else {
                monthlySalesReportTableBody.innerHTML = '<tr><td colspan="6">No data available for selected month.</td></tr>';
            }
        } else {
            alert('Please select a month and year.');
        }
    });

    // Generate Feedback Report
    generateFeedbackReportBtn.addEventListener('click', function () {
        const startDate = feedbackStartDate.value;
        const endDate = feedbackEndDate.value;

        if (startDate && endDate) {
            // Fetch data from backend
            // Simulated data
            const data = [
                { customerName: 'John Doe', date: '2024-09-05', feedback: 'Great service!', rating: 5 },
                { customerName: 'Jane Smith', date: '2024-09-06', feedback: 'Very satisfied.', rating: 4 },
                // Add more data as needed
            ];

            // Clear previous data
            feedbackReportTableBody.innerHTML = '';

            // Populate table with data
            data.forEach(item => {
                const row = `<tr>
                    <td>${item.customerName}</td>
                    <td>${item.date}</td>
                    <td>${item.feedback}</td>
                    <td>${item.rating}</td>
                </tr>`;
                feedbackReportTableBody.insertAdjacentHTML('beforeend', row);
            });
        } else {
            alert('Please select both start and end dates.');
        }
    });

    // Export Feedback Report as PDF
    exportFeedbackPdfBtn.addEventListener('click', function () {
        const { jsPDF } = window.jspdf;
        const doc = new jsPDF();

        doc.text('Customer Feedback Report', 10, 10);
        doc.autoTable({ html: '#feedback-report-table', startY: 20 });
        doc.save('Customer_Feedback_Report.pdf');
    });
});
