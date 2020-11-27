import React, {useState} from 'react'
import MessageList from "./MessageList";
import MessengerFooter from "./MessengerFooter";
import classes from './MessengerWindow.module.css'

export default function MessengerWindow() {
    const [messageList, setMessageList] = useState([{isSelf: false, message: "message"}])
    function addMessageToList(message) {
        setMessageList(prevList => [...prevList,message])
    }
    return (
        <div className={classes.window}>
            <MessageList messageList={messageList}/>
            <MessengerFooter callbackAdd={addMessageToList}/>
        </div>
    )
}