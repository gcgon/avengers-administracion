import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
    history: createWebHistory(
        import.meta.env.BASE_URL),
    routes: [{
            path: '/',
            name: 'home',
            component: HomeView
        },
        {
            path: '/login',
            name: 'login',
            component: () =>
                import ('../views/LoginView.vue')
        },
        {
            path: '/facturasAdministrador',
            name: 'facturasAdministrador',
            component: () =>
                import ('../views/FacturasAdministradorView.vue')
        },
        {
            path: '/conjuntosAdministrador',
            name: 'conjuntosAdministrador',
            component: () =>
                import ('../views/ConjuntosAdministradorView.vue')
        },
        {
            path: '/crearUsuariosAdministrador',
            name: 'crearUsuariosAdministrador',
            component: () =>
                import ('../views/CrearUsuariosAdministradorView.vue')
        },
        {
            path: '/reportesAdministrador',
            name: 'reportesAdministrador',
            component: () =>
                import ('../views/ReportesAdministradorView.vue')
        },
        {
            path: '/inicioEncargado',
            name: 'inicioEncargado',
            component: () =>
                import ('../views/InicioEncargadoView.vue')
        },
        {
            path: '/facturasEncargado',
            name: 'facturasEncargado',
            component: () =>
                import ('../views/FacturasEncargadoView.vue')
        },
        {
            path: '/pagosEncargado',
            name: 'pagosEncargado',
            component: () =>
                import ('../views/PagosEncargadoView.vue')
        },
        {
            path: '/informacionEncargado',
            name: 'informacionEncargado',
            component: () =>
                import ('../views/InformacionEncargadoView.vue')
        }
        {
            path: '/apartamentoAdministrador',
            name: 'apartamentoAdministrador',
            component: () =>
                import ('../views/ApartamentoAdministradorView.vue')
        }
    ]
})

export default router