import React from 'react'
import classes from './Message.module.css'
import joinBySpace from "../utils/joinBySpace";

export default function Message(props) {
    return (
        <div className={joinBySpace(classes.message,props.isSelf ? classes.self : classes.other)}>
            <p>{props.children}</p>
        </div>
    )
}