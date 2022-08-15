let usdToVnd, eurToVnd, eurToUsd;
usdToVnd = 23397;
eurToVnd = 24060;
eurToUsd = 1.03;

let inputAmount, amount, fromCurrency, toCurrency, result, resultUnit;
result = 0;

function currencyChange() {
    inputAmount = document.getElementById('amount').value;
    amount = parseFloat(inputAmount);
    fromCurrency = document.getElementById('from-currency').value;
    toCurrency = document.getElementById('to-currency').value;

    if (fromCurrency === 'VND') {
        switch (toCurrency) {
            case 'USD':
                result = amount / usdToVnd;
                break;
            case 'EUR':
                result = amount / eurToVnd;
                break;
            case 'VND':
                result = amount;
        }
    } else if (fromCurrency === 'USD') {
        switch (toCurrency) {
            case 'EUR':
                result = amount / eurToUsd;
                break;
            case 'VND':
                result = amount * usdToVnd;
                break;
            case 'USD':
                result = amount;
        }
    } else if (fromCurrency === 'EUR') {
        switch (toCurrency) {
            case 'USD':
                result = amount * eurToUsd;
                break;
            case 'VND':
                result = amount * eurToVnd;
                break;
            case 'EUR':
                result = amount;
        }
    }

    document.getElementById('result-value').innerText = result;

    resultUnit = document.getElementById('to-currency').value;
    document.getElementById('result-unit').innerText = resultUnit;
}




