import React, {useState} from 'react'
import Message from "./Message";

export default function MessageList(props) {
    return (
        <div>
            {props.messageList.map((message) => (
                    <Message isSelf={message.isSelf}>{message.message}</Message>
                )
            )}
        </div>
    )
}