// Bài 1: Viết function truyền vào mảng các chuỗi có độ dài bất kỳ. Kết quả trả về là 1 mảng các chuỗi có độ dài lớn nhất
function getStringHasMaxLength(array) {
    let maxLength = 0;
    for (let i = 0; i < array.length; i++) {
        if (array[i].length > maxLength) {
            maxLength = array[i].length;
        }
    }

    let StringHasMaxLength = []
    for (let i = 0; i < array.length; i++) {
        if (array[i].length == maxLength) {
            StringHasMaxLength.push(array[i]);
        }
    }

    return StringHasMaxLength;
}

let array = ['aba', 'aa', 'ad', 'c', 'vcd'];
console.log(array)
console.log(getStringHasMaxLength(array))


// Bài 2:
users = [
    {
        name: "Bùi Công Sơn",
        age: 30,
        isStatus: true
    },
    {
        name: "Nguyễn Thu Hằng",
        age: 27,
        isStatus: false
    },
    {
        name: "Phạm Văn Dũng",
        age: 20,
        isStatus: false
    }
]

//Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age > 25 và isStatus = true
function findAgeOver25(users) {
    let ageOver25 = [];

    users.forEach(user => {
        if (user.age > 25 && user.isStatus == true) {
            ageOver25.push(user);
        }
    });

    return ageOver25;
}
console.log(findAgeOver25(users))

//Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age tăng dần
function sortAgeAsc(users) {
    for (let i = 0; i < users.length; i++) {
        for (let j = 0; j < users.length; j++) {
            if (users[i].age < users[j].age) {
                let temp = users[i];
                users[i] = users[j];
                users[j] = temp;
            }
        }
    }
    return users;
}
console.log(sortAgeAsc(users))


// Bài 3. Viết function truyền vào 1 mảng các chuỗi. Trả về Object hiển thị xem mỗi phần tử trong mảng xuất hiện bao nhiêu lần
function getCountElement(array){
    let map = new Map();
    
    for (let i = 0; i < array.length; i++) {
        if (!map.has(array[i])){
            map.set(array[i], 1);
        } else{
            map.set(array[i], map.get(array[i])+1 );
        }
    }
    console.log(map)
}

let array1 =  ["one", "two", "three", "one", "one", "three"];
getCountElement(array1)