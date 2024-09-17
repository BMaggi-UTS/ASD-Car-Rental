document.addEventListener('DOMContentLoaded', function () {
    const sections = document.querySelectorAll('.report-section h2');
    const generateReportBtn = document.getElementById('generate-report');
    const monthSelect = document.getElementById('month');
    const reportTableBody = document.querySelector('#monthly-report tbody');

    // Toggle report section visibility
    sections.forEach(section => {
        section.addEventListener('click', function () {
            const nextElement = section.nextElementSibling;
            nextElement.classList.toggle('active');
        });
    });

    // Generate report based on selected month
    generateReportBtn.addEventListener('click', function () {
        const selectedMonth = monthSelect.value;
        let reportData = '';

        // Static data for the presentation
        if (selectedMonth === 'September') {
            reportData = `
                <tr>
                    <td>September</td>
                    <td>200</td>
                    <td>150</td>
                    <td>$50000</td>
                    <td>$250</td>
                    <td>$50000</td>
                </tr>
            `;
        } else if (selectedMonth === 'August') {
            reportData = `
                <tr>
                    <td>August</td>
                    <td>180</td>
                    <td>140</td>
                    <td>$45000</td>
                    <td>$250</td>
                    <td>$45000</td>
                </tr>
            `;
        }

        // Fill the table with report data
        reportTableBody.innerHTML = reportData;
    });
});