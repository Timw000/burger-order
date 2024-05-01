import './assets/_input.scss'
import './assets/global.scss'
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia'
import { faCalendar, faCircleLeft, faImage, faFloppyDisk } from '@fortawesome/free-regular-svg-icons'
import { faPlus, faUpRightAndDownLeftFromCenter, faDownLeftAndUpRightToCenter, faCheck, faCircleExclamation, faCircleInfo, faXmark, faGear, faSort, faUpRightFromSquare, faAngleLeft, faAngleRight, faAngleDown, faAngleUp, faWandMagicSparkles, faPencil , faFileArrowDown} from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { library } from '@fortawesome/fontawesome-svg-core'

const pinia = createPinia()

const app = createApp(App)
.use(pinia)
.use(router)

app.component('font-awesome-icon', FontAwesomeIcon)
library.add(faPlus, faUpRightAndDownLeftFromCenter, faDownLeftAndUpRightToCenter, faImage, faFloppyDisk, faPencil, faWandMagicSparkles, faCalendar, faCheck, faCircleExclamation, faCircleInfo, faXmark, faGear, faSort, faCircleLeft, faUpRightFromSquare, faAngleLeft, faAngleRight, faAngleDown, faAngleUp, faFileArrowDown)

app.mount('#app')