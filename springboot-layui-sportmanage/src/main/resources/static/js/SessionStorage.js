function handleSessionStorage(method, key, value) {
    switch (method) {
        case 'get' : {
            let temp = window.sessionStorage.getItem(key);
            if (temp) {
                return temp
            } else {
                return false
            }
        }
        case 'set' : {
            window.sessionStorage.setItem(key, value);
            break
        }
        case 'remove': {
            window.sessionStorage.removeItem(key);
            break
        }
        default : {
            return false
        }
    }
}
