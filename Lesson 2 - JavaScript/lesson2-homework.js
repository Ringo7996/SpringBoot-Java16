let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 3000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]

//function in sản phẩm
function viewProducts(products) {
    for (let i = 0; i < products.length; i++) {
        if (products[i] != null) {
            let info = products[i].name + " - " + products[i].price + " - " + products[i].brand + " - " + products[i].count
            console.log(info);
        }
    }
}


// 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product
console.log("6");
function addProduct(name, price, brand, count) {
    let newProduct = {
        name: name,
        price: price,
        brand: brand,
        count: count
    }
    products.push(newProduct);
}
addProduct("Nokia 1080", 300000, "Nokia", 12);
addProduct("Samsung A53", 15000000, "Samsung", 8);
viewProducts(products);


// 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng
console.log("7");
for (let i = 0; i < products.length; i++) {
    if (products[i].brand == "Samsung") {
        delete products[i];
    }
}
viewProducts(products);


// 8. Sắp xếp giỏ hàng theo price tăng dần
console.log("8");
for (let i = 0; i < products.length; i++) {
    for (let j = 0; j < products.length; j++) {
        if (products[i] != null && products[j] != null && products[i].price < products[j].price) {
            let a = products[i];
            products[i] = products[j];
            products[j] = a;
        }
    }
}
viewProducts(products);


// 9. Sắp xếp giỏ hàng theo count giảm dần
console.log("9");
for (let i = 0; i < products.length; i++) {
    for (let j = 0; j < products.length; j++) {
        if (products[i] != null && products[j] != null && products[i].count > products[j].count) {
            let a = products[i];
            products[i] = products[j];
            products[j] = a;
        }
    }
}
viewProducts(products);


// 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
console.log("10");
do {
    random1 = Math.floor(Math.random() * products.length);
} while (products[random1] == null);

do {
    random2 = Math.floor(Math.random() * products.length);
} while (products[random2] == null || random2 == random1 );

let info = products[random1].name + " - " + products[random1].price + " - " + products[random1].brand + " - " + products[random1].count;
let info2 = products[random2].name + " - " + products[random2].price + " - " + products[random2].brand + " - " + products[random2].count;
console.log(info + "\n" + info2);

