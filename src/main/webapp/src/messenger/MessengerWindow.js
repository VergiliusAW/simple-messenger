import React, {useEffect, useRef, useState} from 'react'
import MessageList from "./MessageList";
import MessengerFooter from "./MessengerFooter";
import classes from './MessengerWindow.module.css'

export default function MessengerWindow(props) {
    const [messageList, setMessageList] = useState([])
    useEffect(() => {
        if (props.user_id !== 0)
            fetch("/api/messages").then(response => {
                response.json()
                    .then(req => {
                        console.log(req)
                        setMessageList(req)
                    })
            })
    }, [props.user_id])

    function addMessageToList(message) {
        message = {
            text_message: message.text_message,
            user_id: props.user_id,
            user_name: props.user_name
        }
        setMessageList(prevList => [...prevList, message])
        fetch("/api/message", {
            method: "post",
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                message: message.text_message,
                user_id: props.user_id
            })
        }).then(r => console.log("message delivered"))
    }

    return (
        <div className={classes.window}>
            {props.user_id !== 0 &&
            <>
                <MessageList user_id={props.user_id} messageList={messageList}/>
                <MessengerFooter callbackAdd={addMessageToList}/>
            </>
            }
        </div>
    )
}