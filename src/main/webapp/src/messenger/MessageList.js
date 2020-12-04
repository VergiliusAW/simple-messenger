import React, {useEffect, useState} from 'react'
import Message from "./Message";
import classes from "./MessageList.module.css"

export default function MessageList(props) {
    useEffect(() => document.getElementById("message-list").scrollTo(0,document.getElementById("message-list").scrollHeight))
    return (
        <div id={"message-list"} className={classes.list}>
            {props.messageList.map((message) => (
                    <Message key={message.id} isSelf={message.isSelf}>{message.message}</Message>
                )
            )}
        </div>
    )
}