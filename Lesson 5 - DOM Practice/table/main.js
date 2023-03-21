let student_warning = {
    students: [
        {
            name: "Lê Hoài Nam",
            email: "namlehoai@gmail.com",
            phone: "123456789",
            total_off: 2,
            sessions: 14,
            detail_info: [
                {
                    date: "01-09-2020",
                    note: "Xin nghỉ ốm",
                    teacher: "Bùi Hiên",
                },
                {
                    date: "05-09-2020",
                    note: "Buồn vì thất tình",
                    teacher: "Nguyễn Hàn Duy",
                },
            ],
        },
        {
            name: "Đỗ Đăng Nguyên",
            email: "nguyen@gmail.com",
            phone: "0123987654",
            total_off: 2,
            sessions: 14,
            detail_info: [
                {
                    date: "01-09-2020",
                    note: "Mưa to nên ngại đi học",
                    teacher: "Bùi Hiên",
                },
                {
                    date: "05-09-2020",
                    note: "Trượt lô, nên rút học phí để đánh",
                    teacher: "Nguyễn Hàn Duy",
                },
            ],
        },
        {
            name: "Nguyễn Xuân Ba",
            email: "3nx92nd@gmail.com",
            phone: "0344005987",
            total_off: 3,
            sessions: 14,
            detail_info: [
                {
                    date: "01-09-2020",
                    note: "Đang training không đi học được",
                    teacher: "Bùi Hiên",
                },
                {
                    date: "07-09-2020",
                    note: "Soạn giáo án đặc vụ 0175",
                    teacher: "Nguyễn Hàn Duy",
                },
                {
                    date: "10-09-2020",
                    note: "Ganks team còng lưng nên chưa đi học được",
                    teacher: "Nguyễn Hàn Duy",
                },
            ],
        },
    ],
    class: "Lập trình Game 2D Canvas",
    course: "Lập trình Game",
    sessions: 14,
    teachers: [
        {
            name: "Bùi Hiên",
            email: "hien@techmaster.vn",
            phone: "0123456789",
        },
        {
            name: "Nguyễn Hàn Duy",
            email: "duy@techmaster.vn",
            phone: "0987654321",
        },
    ],
};


let students = student_warning.students;
let tbody = document.querySelector("tbody")
tbody.innerHTML = ""


for (let i = 0; i < students.length; i++) {
    let student = students[i]
    let offNumber = student.detail_info.length
    let tr = document.createElement("tr");

    let tdID = document.createElement("td");
    tdID.rowSpan = offNumber;
    tdID.innerText = i + 1;
    tr.appendChild(tdID);

    let tdName = document.createElement("td");
    tdName.rowSpan = offNumber;
    tdName.innerText = student.name;
    tr.appendChild(tdName);

    let tdEmail = document.createElement("td");
    tdEmail.rowSpan = offNumber;
    tdEmail.innerText = student.email;
    tr.appendChild(tdEmail);

    let tdPhone = document.createElement("td");
    tdPhone.rowSpan = offNumber;
    tdPhone.innerText = student.phone;
    tr.appendChild(tdPhone);

    let tdAbsent = document.createElement("td");
    tdAbsent.rowSpan = offNumber;
    tdAbsent.classList.add("text-center");
    tdAbsent.innerText = `${student.total_off}/${student.sessions}`;
    tr.appendChild(tdAbsent);

    let tdAbsentDay0 = document.createElement("td");
    tdAbsentDay0.classList.add("text-center");
    tdAbsentDay0.innerText = student.detail_info[0].date;
    tr.appendChild(tdAbsentDay0);

    let tdNote0 = document.createElement("td");
    tdNote0.innerText = student.detail_info[0].note;
    tr.appendChild(tdNote0);

    let tdTeacher0 = document.createElement("td");
    tdTeacher0.innerText = student.detail_info[0].teacher;
    tr.appendChild(tdTeacher0);

    tbody.appendChild(tr);

    for (let i = 1; i < offNumber; i++) {
        let tri = document.createElement("tr");

        let tdAbsentDayi = document.createElement("td");
        tdAbsentDayi.classList.add("text-center");
        tdAbsentDayi.innerText = student.detail_info[i].date;
        tri.appendChild(tdAbsentDayi);


        let tdNotei = document.createElement("td");
        tdNotei.innerText = student.detail_info[i].note;
        tri.appendChild(tdNotei);

        let tdTeacheri = document.createElement("td");
        tdTeacheri.innerText = student.detail_info[i].teacher;
        tri.appendChild(tdTeacheri);
        tbody.appendChild(tri);
    }
}


let classInner = document.querySelector(".class-inner")

let className = document.createElement("p");
className.innerHTML = `<span>Lớp học</span> : ${student_warning.class}`
classInner.replaceChild(className, classInner.children[0])

let course = document.createElement("p");
course.innerHTML = `<span>Thuộc khóa học</span> : ${student_warning.course}`
classInner.replaceChild(course, classInner.children[1])

let teacherList = classInner.children[3]
teacherList.innerHTML = "";
for (let i = 0; i < student_warning.teachers.length; i++) {
    let teacher = student_warning.teachers[i];
    let li = document.createElement("li");
    li.innerText = ` ${teacher.name} ( ${teacher.email} - ${teacher.phone})`
    teacherList.appendChild(li)
}

let sessions = document.createElement("p");
sessions.innerHTML = `<span>Tổng số buổi </span> : ${student_warning.sessions}`
classInner.replaceChild(sessions, classInner.lastElementChild)
