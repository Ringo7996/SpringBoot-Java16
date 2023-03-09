// Danh sách các sản phẩm có trong giỏ hàng
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
        name: "OPPO Find X3 PRo",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]


// 1. In ra thông tin các sản phẩm trong giỏ hàng theo cấu trúc sau
// Tên - Giá - Thương Hiệu - Số lượng
for (let i = 0; i < products.length; i++) {
    let info = products[i].name + " - " + products[i].price + " - " + products[i].brand + " - " + products[i].count
    console.log(info);
}

// 2. Tính tổng tiền tất cả sản phẩm trong giỏ hàng
// Tổng tiền mỗi sản phẩm = price * count
let totalMoney = 0;
for (let i = 0; i < products.length; i++) {
    totalMoney += products[i].price * products[i].count;
}
console.log("tổng tiền: " + totalMoney);


// 3. Tìm các sản phẩm của thuơng hiệu "Apple"
console.log("3");
for (let i = 0; i < products.length; i++) {
    if (products[i].brand == "Apple") {
        let info = products[i].name + " - " + products[i].price + " - " + products[i].brand + " - " + products[i].count
        console.log(info);
    }
}


// 4. Tìm các sản phẩm có giá > 20000000
console.log("4");
for (let i = 0; i < products.length; i++) {
    if (products[i].price > 20000000) {
        let info = products[i].name + " - " + products[i].price + " - " + products[i].brand + " - " + products[i].count
        console.log(info);
    }
}


// 5. Tìm các sản phẩm có chữ "pro" trong tên (Không phân biệt hoa thường)
console.log("5");
for (let i = 0; i < products.length; i++) {
    if (products[i].name.toLowerCase().includes("pro")) {
        let info = products[i].name + " - " + products[i].price + " - " + products[i].brand + " - " + products[i].count
        console.log(info);
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

addProduct("Abc", 100000, "Oppo", 12);
for (let i = 0; i < products.length; i++) {
    let info = products[i].name + " - " + products[i].price + " - " + products[i].brand + " - " + products[i].count
    console.log(info);
}



// 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng
console.log("7");
for (let i = 0; i < products.length; i++) {
    if (products[i].brand = "Samsung") {
        products.splice(i,1);
    }
}
for (let i = 0; i < products.length; i++) {
    let info = products[i].name + " - " + products[i].price + " - " + products[i].brand + " - " + products[i].count
    console.log(info);
}


// 8. Sắp xếp giỏ hàng theo price tăng dần
console.log("8");
for (let i = 0; i < products.length; i++) {
    for (let j = 0; j < products.length; j++) {
        if (products[i].price < products[j].price) {
            let a = products[i];
            products[i] = products[j];
            products[j] = a;
        }
    }
}
for (let i = 0; i < products.length; i++) {
    let info = products[i].name + " - " + products[i].price + " - " + products[i].brand + " - " + products[i].count
    console.log(info);
}


// 9. Sắp xếp giỏ hàng theo count giảm dần
console.log("9");
for (let i = 0; i < products.length; i++) {
    for (let j = 0; j < products.length; j++) {
        if (products[i].count > products[j].count) {
            let a = products[i];
            products[i] = products[j];
            products[j] = a;
        }
    }
}
for (let i = 0; i < products.length; i++) {
    let info = products[i].name + " - " + products[i].price + " - " + products[i].brand + " - " + products[i].count;
    console.log(info);
}


// 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
console.log("10");
let random1 = Math.floor(Math.random() * products.length);
let random2 = Math.floor(Math.random() * products.length);
while (random2 == random1) {
    random2 = Math.floor(Math.random() * products.length);
}
let info = products[random1].name + " - " + products[random1].price + " - " + products[random1].brand + " - " + products[random1].count;
let info2 = products[random2].name + " - " + products[random2].price + " - " + products[random2].brand + " - " + products[random2].count;
console.log(info + "\n" + info2);






///products.sort(function (product A, productB) ){
// return productA.key - productB.key
//}