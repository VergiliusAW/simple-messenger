import React, {useState} from 'react';
import join from '../utils/joinBySpace'
import classes from './MessengerFooter.module.css'

function FooterProfile() {
    return (
        <>
        </>
    )
}

function MessengerInput() {
    return (
        <input
            id={'inp-msg'}
            className={classes.input}
            autoComplete={'off'}>
        </input>
    )
}

function FooterSendButton(props) {
    const [hovered, setHovered] = useState(false);
    const toggleHover = () => setHovered(!hovered);
    return (
        <div
            className={join(classes.svg, hovered ? classes.svgHovered : '')}
            onMouseEnter={toggleHover}
            onMouseLeave={toggleHover}
            onClick={props.action}
        >
            <svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd">
                <path
                    d="M24 12c0 6.623-5.377 12-12 12s-12-5.377-12-12 5.377-12 12-12 12 5.377 12 12zm-1 0c0 6.071-4.929 11-11 11s-11-4.929-11-11 4.929-11 11-11 11 4.929 11 11zm-11.5-4.828l-3.763 4.608-.737-.679 5-6.101 5 6.112-.753.666-3.747-4.604v11.826h-1v-11.828z"/>
            </svg>
        </div>
    )
}

function FooterButton(props) {
    return (
        <div
            className={classes.button}>
            <FooterSendButton
                action={props.addFunc}
            />
        </div>
    )
}

export default function MessengerFooter(props) {

    const submit = (event) => {
        event.preventDefault()
        buttonAction()
    }

    function buttonAction() {
        const message = {
            isSelf: true,
            message: document.getElementById('inp-msg').value
        }
        if (message.message.replaceAll(" ","")!=="") {
            props.callbackAdd(message)
            document.getElementById('inp-msg').value = ""
        }
        // console.log('Отправляет данные из инпута на сервер. Пока ожидает отправки появляется лоадер')
    }

    return (
        <form
            className={classes.footer}
            onSubmit={submit}
        >
            <FooterProfile/>
            <MessengerInput/>
            <FooterButton
                addFunc={buttonAction}
            />
        </form>
    )
}