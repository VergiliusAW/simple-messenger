import React, {useEffect, useState} from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import reportWebVitals from './reportWebVitals';
import MessengerWindow from "./messenger/MessengerWindow";
import * as PropTypes from "prop-types";

function Page() {
    const [user_id, setUser_id] = useState(0)
    const [user_name, setUser_name] = useState("")
    function doFetch() {
        let login = prompt("User name:", "")
        let password = prompt("Password:")
        fetch("/api/getId", {
            method: "post",
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                login: login,
                password: password
            })
        }).then((response) => {
            response.json().then(res => {
                console.log(res)
                if (res.user_id != null) {
                    setUser_id(res.user_id)
                    setUser_name(res.user_name)
                }
                else
                    doFetch()
            }).catch(() => {
                doFetch()
            })
        })
    }

    useEffect(() => {
        doFetch()
    }, [])
    return <MessengerWindow user_id={user_id} user_name={user_name}/>;
}

Page.propTypes = {children: PropTypes.node};
ReactDOM.render(
    <React.StrictMode>
        <Page/>
    </React.StrictMode>,
    document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
