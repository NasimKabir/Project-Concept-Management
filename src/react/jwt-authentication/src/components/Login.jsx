import React,{useState}  from "react";
import AuthService from '../services/auth.service';
import '../App.css';

const Login = (props) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const onChangeUsername = (e) => {
    const username = e.target.value;
    setUsername(username);
  };

  const onChangePassword = (e) => {
    const password = e.target.value;
    setPassword(password);
  };

  
  const submit = async (event) => {
    event.preventDefault();
    AuthService
      .login(username,password).then(
        () => {
           props.history.push('/add');
          console.log("success")
        },
       
         error => {
           const errorMessage="Can not signin successfully ! Please check username/password again";
          console.log("Login fail: error = { " + error.toString() + " }");
           setError(errorMessage); 
        } 
      );
  }

  return (
    <div className="loginPage">

       {error && (
            <div className="form-group">
              <div className="alert alert-danger" role="alert">
                {error}
              </div>
            </div>
          )}
       <form onSubmit={submit}>
            <h1 className="h3 mb-3 fw-normal">Please sign in</h1>
            <input type="text" className="form-control" placeholder="Username" required
                   onChange={onChangeUsername}
            />
<br />
            <input type="password" className="form-control" placeholder="Password" required
                   onChange={onChangePassword}
            />
<br />
            <button className="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        </form>
    </div>    
  )
}  

export default Login

