import i18n from 'i18next';
import { initReactI18next} from 'react-i18next';
import enJSON from "en.json";
import esJSON from "es.json";

i18n.use(initReactI18next).init({
    resources: {
        en: { ...enJSON },
        es: { ...esJSON },
    },  // Translation files
    lng: 'en',  // Default language
    interpolation: {
        escapeValue: false,
    },
});

