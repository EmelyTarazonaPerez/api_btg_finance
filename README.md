# api_btg_fondos

## Development environment.
[![IntelliJ IDEA](https://img.shields.io/badge/intelliJIDEA-black?style=for-the-badge&logo=openjdk)](https://github.com/JulianRivers)
[![Java](https://img.shields.io/badge/java-black?style=for-the-badge&logo=openjdk)](https://github.com/JulianRivers)
[![Springboot](https://img.shields.io/badge/springboot-black?style=for-the-badge&logo=springboot)](https://github.com/JulianRivers)

## Enpoint created
| Enpoint | Description |
| --- | --- |
| GET getFonds | http://localhost:8085/btg/finance/funds |
| GET getTransactions |http://localhost:8085/btg/finance/transactions |
| GET getDemoUser | http://localhost:8085/btg/finance/users/demo |
| POST subscribeFund |http://localhost:8085/btg/finance/funds/subscribe|
| POST unsubscribeFund |http://localhost:8085/btg/finance/funds/unsubscribe/66c939b23d81b377b2ff58fc |

## Preview
GET getFonds
~~~
[
    {
        "id": "66c84b1909615de3c123c2fb",
        "name": "BTG PACTUAL RECAUDADORA",
        "code": "FPV_BTG_PACTUAL_RECAUDADORA",
        "min_amount": 75000.0,
        "category": "FVP"
    },
    {
        "id": "66c84b8e09615de3c123c2fc",
        "name": "BTG PACTUAL ECOPETROL",
        "code": "FPV_BTG_PACTUAL_ECOPETROL",
        "min_amount": 125000.0,
        "category": "FVP"
    },
    {
        "id": "66c84bb309615de3c123c2fd",
        "name": "DEUDAPRIVADA",
        "code": "DEUDAPRIVADA",
        "min_amount": 50000.0,
        "category": "FIC"
    },
    {
        "id": "66c84bdb09615de3c123c2fe",
        "name": "FDO ACCIONES",
        "code": "FDO-ACCIONES",
        "min_amount": 250000.0,
        "category": "FIC"
    },
    {
        "id": "66c84c0c09615de3c123c2ff",
        "name": "BTG PACTUAL DINAMICA",
        "code": "FPV_BTG_PACTUAL_DINAMICA",
        "min_amount": 100000.0,
        "category": "FPV"
    }
]
~~~
