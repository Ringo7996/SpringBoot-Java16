import { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams } from "react-router-dom";


let fileList = [];
const API_URL_USER = "http://localhost:8080/api/v1/users"
const API_URL_FILE = "http://localhost:8080/api/v1/files"

function FilePage() {
    const [files, setfiles] = useState([])
    const { userId } = useParams();

    useEffect(() => {
        getFileList()
    }, [])

    // useEffect(() => {
    // }, [files])


    const getFileList = async () => {
        let res = await axios.get(`${API_URL_USER}/${userId}/files`)
        fileList = res.data;
        console.log("fileList", fileList)
        setfiles(fileList);
    }

    const deleteFile = async (fileId) => {
        let confirm = window.confirm("Are you sure to delete this file?")
        if (!confirm) {
            return;
        }
        try {
            let res = await axios.delete(`${API_URL_FILE}/${fileId}`)
            fileList = fileList.filter((file) => file.id !== fileId);
            console.log("fileList after delete", fileList);
            setfiles(fileList)
        } catch (error) {
            console.log(error)
        }
    }

    const uploadFile = async (event) => {
        const file = event.target.files[0];
        const formData = new FormData();
        formData.append("file", file);

        console.log("chekc fileList1", fileList)
        try {
            let res = await axios.post(`${API_URL_USER}/${userId}/files`, formData)

            let newFileList = fileList.push(res.data);
            setfiles(newFileList);
        } catch (error) {
            console.log(error)
        }
    }



    const formatDate = (dateString) => {
        const date = new Date(dateString);
        const year = date.getFullYear();
        const month = `0${date.getMonth() +1}`.slice(-2);
        const day =  `0${date.getDate()}`.slice(-2);

        return `${day}/${month}/${year}`;
    }


    return (
        <body>
            <div className="container">
                <h2 className="mt-5 mb-3">Danh sách file</h2>
                <input type="file" id="input-file" hidden="hidden" onChange={(event) => uploadFile(event)}></input>
                <label htmlFor="input-file" className="btn btn-warning mb-3" >Upload file</label>
                <div className="row">
                    <div className="col-6">
                        <table className="table table-hover table-bordered">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Type</th>
                                    <th>CreateAt</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {fileList.map((file) => (
                                    <tr key={file.id} >
                                        <td>{file.id}</td>
                                        <td>{file.type}</td>
                                        <td>{`${formatDate(file.createAt)}`}</td>
                                        <td><a href={`${API_URL_FILE}/${file.id}`} target="_blank">Detail</a></td>
                                        <td><button className="btn btn-danger" onClick={() => deleteFile(file.id)} > Delete</button></td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </body >

    )
}

export default FilePage
