import { Router } from "@angular/router";

export function reloadCurrentRoute(route:Router) {
    const currentUrl = route.url;
    route.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      route.navigate([currentUrl]);
    });
}