const btn = document.getElementById('btn');
const image = document.getElementById('image');
const select = document.getElementById('select');

// Vừa load trang phải gọi API để render danh sách breed
// API : https://dog.ceo/api/breeds/list/all

async function getBreedList() {
    // Gọi API để lấy danh sách giống loài
    let res = await axios.get("https://dog.ceo/api/breeds/list/all")

    // Sau khi có data thì hiển thị kết quả trên giao diện
    renderBreed(res.data.message)
}


function renderBreed(breeds) {
    // Duyệt qua object breeds -> tạo thẻ option -> gắn vào DOM
    console.log(breeds)
    let select = document.getElementById("breed-list");

    for (const key in breeds) {
        let option = document.createElement("option");
        option.value = key;
        option.innerText = key;
        select.insertAdjacentElement("beforeEnd", option);
    }

    let getSubBreeds = document.getElementById("btn");
    getSubBreeds.innerText = "Get Sub Breed"
    getSubBreeds.addEventListener("click", function () {
        let subBreedList = select.value;
        getSubBreedList(subBreedList)
    })
}

getBreedList()




async function getSubBreedList(breed) {
    // Gọi API để lấy danh sách giống loài
    let sublistURL = "https://dog.ceo/api/breed/" + breed + "/list";
    let res = await axios.get(sublistURL)

    // Sau khi có data thì hiển thị kết quả trên giao diện
    renderSubBreed(breed, res.data.message)
}



function renderSubBreed(breed, subBreed) {
    // if-else tìm ul, nếu có thì gán innerHTML rỗng, nếu chưa thì chạy tạo mới.

    let ul = document.querySelector(".form > ul")
    if (ul) {
        ul.innerHTML = "";
    } else {
        ul = document.createElement("ul");
    }

    if (subBreed.length == 0) {
        let thongbao = document.createElement("ul");
        thongbao.innerText = "Không có sub breed";
        btn.insertAdjacentElement("afterEnd", thongbao);
        return;
    }


    subBreed.forEach(element => {
        let li = document.createElement("li");
        li.innerText = element;
        ul.appendChild(li);
        li.addEventListener("click", function () {
            getImage(breed, element);
        })
    });
    btn.insertAdjacentElement("afterEnd", ul);

}

// getImage(breed, subBreed)


async function getImage(breed, subBreed) {
    // Gọi API để lấy danh sách giống loài
    let imageURL = "https://dog.ceo/api/breed/" + breed + "/" + subBreed + "/images/random";
    let res = await axios.get(imageURL)
    let image = document.getElementById("image");
    image.src = res.data.message;
    console.log(res.data.message);

    // Sau khi có data thì hiển thị kết quả trên giao diện
    // renderSubBreed(res.data.message)
}

// getImage("hound", "afghan");