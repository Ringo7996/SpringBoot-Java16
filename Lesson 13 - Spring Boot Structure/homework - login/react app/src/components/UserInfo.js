
function UserInfo(props) {
  if (props.user.id) {
    return (
      <div className="user-info">
        <h3>Xin chào {props.user.username}</h3>
        <p>Username: {props.user.username} </p>
        <p>Email: {props.user.email} </p>
        <p>Avatar: {props.user.avatar} </p>
      </div>
    );
  } else {
    return (
      <div>
      </div>)
  }

}

export default UserInfo;
