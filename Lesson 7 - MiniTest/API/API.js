
let posts = document.getElementById("posts");
let photos = document.getElementById("photos");
let albums = document.getElementById("albums");
let content = document.getElementById("content");

getData("posts")
async function getData(data) {
    let res = await axios.get(`https://jsonplaceholder.typicode.com/${data}`)
    renderData(res.data);
    console.log(res.data)
}
function renderData(res) {
    let ul = document.createElement("ul");
    for (let i = 0; i < res.length; i++) {
        let li = document.createElement("li");
        li.textContent = res[i].title
        ul.appendChild(li)
    }
    content.append(ul)
}

posts.addEventListener("click", function(){
    posts.style.backgroundColor = "red";
    photos.style.backgroundColor = null;
    albums.style.backgroundColor = null;
    content.innerHTML = "";
    getData("posts")
})


photos.addEventListener("click", function(){
    photos.style.backgroundColor = "red";
    posts.style.backgroundColor = null;
    albums.style.backgroundColor = null;
    content.innerHTML = "";
    getData("photos")
})

albums.addEventListener("click", function(){
    albums.style.backgroundColor = "red";
    photos.style.backgroundColor = null;
    posts.style.backgroundColor = null;
    content.innerHTML = "";
    getData("albums")
})
