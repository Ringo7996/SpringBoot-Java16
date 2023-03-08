// Bài 1: Tạo biến day có giá trị từ 0 -> 6, là các ngày trong tuần. Sử dụng switch-case để in ra ngày tương ứng với giá trị của biến day
let day = 6;
switch (day) {
    case 0: {
        console.log("Hôm nay là chủ nhật");
        break;
    }
    case 1: {
        console.log("Hôm nay là thứ 2");
        break;
    }
    case 2: {
        console.log("Hôm nay là thứ 3");
    }
    case 3: {
        console.log("Hôm nay là thứ 4");
    }
    case 4: {
        console.log("Hôm nay là thứ 5");
    }
    case 5: {
        console.log("Hôm nay là thứ 6");
    }
    case 6: {
        console.log("Hôm nay là thứ 7");
    }
}


//Bài 2: Tạo biến month có giá trị từ 1 -> 12, là các tháng trong năm. Sử dụng switch-case để in ra mùa tương ứng với giá trị của biến month
let month = 11;
switch (month) {
    case 1:
    case 2:
    case 3: {
        console.log("Mùa xuân");
        break;
    }
    case 4:
    case 5:
    case 6: {
        console.log("Mùa hạ");
        break;
    }
    case 7:
    case 8:
    case 9: {
        console.log("Mùa thu");
        break;
    }
    case 10:
    case 11:
    case 12: {
        console.log("Mùa đông");
        break;
    }
}