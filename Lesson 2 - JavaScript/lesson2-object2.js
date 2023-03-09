const grades = [
    { name: 'John', grade: 8, sex: 'M' },
    { name: 'Sarah', grade: 12, sex: 'F' },
    { name: 'Bob', grade: 16, sex: 'M' },
    { name: 'Johnny', grade: 2, sex: 'M' },
    { name: 'Ethan', grade: 4, sex: 'M' },
    { name: 'Paula', grade: 18, sex: 'F' },
    { name: 'Donald', grade: 5, sex: 'M' },
    { name: 'Jennifer', grade: 13, sex: 'F' },
    { name: 'Courtney', grade: 15, sex: 'F' },
    { name: 'Jane', grade: 9, sex: 'F' }
]

// 1.Viết function tính thứ hạng trung bình của cả lớp
function avgGrade(grades) {
    let totalGrade = 0;
    for (let i = 0; i < grades.length; i++) {
        totalGrade += grades[i].grade;
    }

    return totalGrade / (grades.length);
}
console.log(avgGrade(grades));


// 2.Viết function tính thứ hạng trung bình của nam trong lớp
function avgMaleGrade(grades) {
    let totalMaleGrade = 0;
    let MaleNumber = 0;
    for (let i = 0; i < grades.length; i++) {
        if (grades[i].sex == "M") {
            totalMaleGrade += grades[i].grade;
            MaleNumber++;
        }
    }
    return totalMaleGrade / MaleNumber;
}
console.log(avgMaleGrade(grades));


// 3. Viết function tính thứ hạng trung bình của Nữ trong lớp

function avgFemaleGrade(grades) {
    let totalFemaleGrade = 0;
    let FemaleNumber = 0;
    for (let i = 0; i < grades.length; i++) {
        if (grades[i].sex == "F") {
            totalFemaleGrade += grades[i].grade;
            FemaleNumber++;
        }
    }
    return totalFemaleGrade / FemaleNumber;
}
console.log(avgFemaleGrade(grades));


// 4. Viết function tìm học viên Nam có thứ hạng cao nhất trong lớp
function greatestGradeMale(grades) {
    let greatestGradeMale = 0;
    let index = -1;
    for (let i = 0; i < grades.length; i++) {
        if (grades[i].sex == "F"){
            continue;
        }
        if (grades[i].grade > greatestGradeMale) {
            greatestGradeMale = grades[i].grade;
            index = i;
        }
    }
    return grades[index];
}
console.log(greatestGradeMale(grades));

//5. Viết function tìm học viên Nữ có thứ hạng cao nhất trong lớp
function greatestGradeFemale(grades) {
    let greatestGradeFemale = 0;
    let index = -1;
    for (let i = 0; i < grades.length; i++) {
        if (grades[i].sex == "M"){
            continue;
        }
        if (grades[i].grade > greatestGradeFemale) {
            greatestGradeFemale = grades[i].grade;
            index = i;
        }
    }
    return grades[index];
}
console.log(greatestGradeFemale(grades));

// 6. Viết function tìm học viên Nam có thứ hạng thấp nhất trong lớp
console.log("6");
function worstGradeFemale(grades) {
    let worstGradeFemale = grades[0].grade;
    let index = -1;
    for (let i = 0; i < grades.length; i++) {
        if (grades[i].sex == "M"){
            continue;
        }

        console.log(grades[i] + "  " + grades[i].grade);
        console.log(worstGradeFemale);
        if (grades[i].grade < worstGradeFemale) {

            worstGradeFemale = grades[i].grade;
            index = i;
        }
    }
    return grades[index];
}
console.log(worstGradeFemale(grades));


// 7. Viết function tìm học viên Nữ có thứ hạng thấp nhất trong lớp